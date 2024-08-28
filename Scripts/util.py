from pydriller import Repository
from git import Repo
import os
from main import *
import requests
import time
from datetime import datetime

print("git repo clone starting...")


# repoLink = f"https://{user}:{password}@gerrit.ericsson.se/a/OSS/com.ericsson.oss.appEngineering/eric-oss-adc-app-engineering" 

print("connecting to server")
reqRepo = requests.get('http://spring-boot:9090/repo/name')
print("connected to server")


print("Waiting for client input (name)")
time.sleep(10)
while(not reqRepo.headers.get('content-type') == 'application/json'):
    time.sleep(5)
    reqRepo = requests.get('http://spring-boot:9090/repo/name')

print("request recieved (name)")
print(reqRepo.json())
reqJson = reqRepo.json()

# setting repo info from rest
repoLink = reqJson['name']
repoName = reqJson['name'].split('/')[-1]
repoDir = "/repo/"+repoName
dataDir = "/data"

# pulling repo locally
os.makedirs(dataDir, exist_ok = True)

try:
    print("Repo found locally, pulling repo from origin")
    repoCheck = Repo(repoDir).git_dir
    repo = Repo(repoDir)
    repo .remotes.origin.pull()
except:
    print("Repo not found locally, creating directory and pulling repo")
    Repo.clone_from( repoLink, repoDir)

print("git repo clone finished...")

# getting repo dates to return to client
dates = []

for commit in Repository(repoDir).traverse_commits():
    date = str(commit.committer_date)[:10]
    dates.append(date)

reqJson['dateStart'] = dates[0]
reqJson['dateEnd'] = dates[-1]

resRepo = requests.post('http://spring-boot:9090/repo/pname', json= reqJson)
print("response sent ")
print(resRepo)

# getting dates selected by client
reqDate = requests.get('http://spring-boot:9090/repo/date')
    
print("Waiting for client input (date)")
while(not reqDate.headers.get('content-type') == 'application/json'):
    time.sleep(5)
    reqDate = requests.get('http://spring-boot:9090/repo/date')

print("Request recivied (date)")

dateJson = reqDate.json()

while(dateJson['dateStart'] is None and dateJson['dateEnd'] is None):
    time.sleep(5)
    reqDate = requests.get('http://spring-boot:9090/repo/date')
    dateJson = reqDate.json()

firstDate = dateJson['dateStart']
lastDate = dateJson['dateEnd']


firstCommit = datetime.strptime(firstDate, '%Y-%m-%d')
lastCommit = datetime.strptime(lastDate, '%Y-%m-%d')

gitMiner = GitMiner(repoName, firstCommit, lastCommit)
gitMiner.main()
