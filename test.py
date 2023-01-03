import requests

url = "https://sehatichatbot-3vytn6mz2a-et.a.run.app/"
# url = "http://localhost:5000/"

resp = requests.post(url, data ={"chat": "sedih"})

print(resp.json())