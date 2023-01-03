#1
import os
import string
from os import path
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

#2
import tensorflow as tf
from tensorflow import keras
import numpy as np
import random
import pandas as pd
import nltk
nltk.download('punkt')
#biar auto kedownload punknya

#dont forget to import lancaster
# stemmer = LancasterStemmer()

from Sastrawi.Stemmer.StemmerFactory import StemmerFactory
from nltk.tokenize import word_tokenize
factory = StemmerFactory()
stemmer = factory.create_stemmer()

#3
import json
import pickle
import warnings
from tensorflow.keras.models import load_model
warnings.filterwarnings("ignore")
print(tf.__version__)

#INI PENTING import flash, request, and jsonify#

from flask import Flask, request, jsonify

keras.backend.clear_session()
#model = tf.keras.models.load_model("model.h5")
#load_model

def get_model():
    global graph
    graph = tf.compat.v1.get_default_graph()
    with graph.as_default():
        global model
        model = load_model("./model.h5")
        model._make_predict_function()
        print("Model Loaded")

#root = os.path.dirname(path.abspath(__file__))
download_dir = os.path.dirname('./nltk_data')
os.chdir(download_dir)
nltk.data.path.append(download_dir)

#print(nltk)#
# t = nltk.data.load('my_nltk_dir/tokenizers/punkt/english.pickle')
# nltk.data.load('my_nltk_dir/tokenizers/punkt/PY3/english.pickle')
#load json#
with open('./intents.json') as json_data:
    intents = json.load(json_data)

#load pickle#
data = pickle.load( open( "./training_data", "rb" ) ) #inipickle

#load nltk#
# nltk = pickle.load(open("my_nltk_dir/tokenizers/punkt/PY3/english.pickle", "rb")) #nltk

words = data['words']
classes = data['classes']
train_x = data['train_x']
train_y = data['train_y']

ERROR_THRESHOLD = 0.25

def response(sentence, show_details=False):
    #tokenize kata
    global data
    sentence = sentence.translate(str.maketrans('','',string.punctuation)).lower()
    sentence_words = word_tokenize(sentence)
    #INGET sentence_words = nltk.word_tokenize(sentence)

    # hilangin imbuhan, ambil kata dasar
    sentence_words = [stemmer.stem(word.lower())for word in sentence_words]

    bag = [0] * len(words)
    for s in sentence_words:
        for i, w in enumerate(words):
            if w == s:
                bag[i] = 1
                if show_details:
                    print("found in bag: %s" % w)
    bow = np.array(bag)

    input = pd.DataFrame([bow], dtype=np.float32, index=['input'])
    get_model() #ngeload model function terakhir

    results = model.predict([input])[0]
    results = [[i, r] for i, r in enumerate(results) if r > ERROR_THRESHOLD]

    results.sort(key=lambda x: x[1], reverse=True)
    return_list = []
    for r in results:
        return_list.append((classes[r[0]], r[1]))
        #Tupple > Probability dan Intent

    results = return_list
    if results:
        # ngeloop dulu bos sampai dapet
        while results:
            for i in intents['intents']:
                #cari tag dulu
                if i['tag'] == results[0][0]:
                    # mengambil response secara acak
                    output = random.choice(i['responses'])
                    return output

            # results.pop(0)

app = Flask(__name__)

@app.route("/", methods=["GET", "POST"])
def index():
    if request.method == "POST":
        input_data = request.form['chat']
        if input_data is None or input_data == "":
            return jsonify({"error": "no words, empty form"})

        if input_data.lower() == "quit":
            return jsonify({"success": "Thanks for your time. :D"})
        else:
            try:
                data = jsonify({"response": str(response(input_data))})
                # print(results)
                return data
            except Exception as e:
                return jsonify({"error": str(e)})


    return "OK"


if __name__ == '__main__':
    app.run(debug=True, host="0.0.0.0", port=int(os.environ.get("PORT",8080)))