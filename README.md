# SehatI Capstone Project
## Cloud Computing API Documentation

**What you will need :**
1. [Dockerfile](https://github.com/faishalarr/Product-Capstone-Bangkit-2022/blob/master/Dockerfile) as a container image.
2. [requirements.txt](https://github.com/faishalarr/Product-Capstone-Bangkit-2022/blob/master/requirements.txt) contains needed dependencies for ML.
3. [.dockerignore](https://github.com/faishalarr/Product-Capstone-Bangkit-2022/blob/master/.dockerignore) contains files to be ignored.


**Build Docker Images**
<br>
<br>
<code>gcloud builds submit --tag gcr.io/<project_id>/<images_name></code>

this command used to build Dockerfile into docker images

![image](https://user-images.githubusercontent.com/99339256/173182007-1bca3a08-f49b-46a0-ac03-a8e0b8066197.png)

if process is success the output will be like this :
  ![image](https://user-images.githubusercontent.com/99339256/173182053-a5d422a7-a1ba-4abe-ad00-7f16c523016b.png)

  
**Deploying to Cloud Run**
  <br>
  <br>
  <code>gcloud run deploy --image gcr.io/<project_id>/<images_name> --platform managed</code>
    
enter service name and choose region 
    
 ![image](https://media.discordapp.net/attachments/946372508800667689/985113892143398992/unknown.png?width=846&height=662)
    
 when the deployment is finished, in cloud run page the service will appeared
   ![image](https://user-images.githubusercontent.com/99339256/173182365-6b5f54ea-1542-4164-a6b7-4e59dd1a7f39.png)

# ujianrpl_alwimaulanaabdi
