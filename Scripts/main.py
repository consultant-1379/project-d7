import pandas as pd
from pydriller.metrics.process.contributors_count import ContributorsCount
from pydriller import Repository
from pydriller.metrics.process.lines_count import LinesCount
from pydriller.metrics.process.change_set import ChangeSet
from pydriller.metrics.process.code_churn import CodeChurn
from pydriller.metrics.process.hunks_count import HunksCount
from pydriller.metrics.process.contributors_experience import ContributorsExperience

class GitMiner:

    def __init__(self, repoName, firstCommit, lastCommit):
        self.repoName = repoName
        self.repoDir = "/repo/" + self.repoName
        self.dataDir = "/data"
        self.firstCommit = firstCommit
        self.lastCommit = lastCommit
        self.files_analysis_obj = {}
        self.general_repo_analysis = {}
        self.fileNames = []
        self.authorsObj = {}


    def commitsPerDate(self):

        datesArray = []
        numberOfCommits = []
        mockDatesObj = {}

        for commit in Repository(self.repoDir, since=self.firstCommit, to=self.lastCommit).traverse_commits():
            date = str(commit.committer_date)[:10]
            
            if not date in mockDatesObj:
                mockDatesObj[date] = 1
            else:
                mockDatesObj[date] = mockDatesObj[date] + 1

        for key, value in mockDatesObj.items():
            datesArray.append(key)
            numberOfCommits.append(value)

        datesObj = {}
        datesObj["Number of Commits"] = numberOfCommits
        datesObj["Date"] = datesArray

        datesdf = pd.DataFrame(datesObj)
        datesdf

        datesdf.to_csv(self.dataDir +"/dates.csv", index = False)


    def contributorsCount(self):
        contributorCount = []
        minorContributorCount = []

        metric = ContributorsCount(path_to_repo= self.repoDir,
                                since= self.firstCommit,
                                to= self.lastCommit)

        count = metric.count()
        minor = metric.count_minor()

        for key, value in count.items():
            self.fileNames.append(key)
            contributorCount.append(value)
            
        for key, value in minor.items():
            minorContributorCount.append(value)


        self.files_analysis_obj["File"] = self.fileNames
        self.files_analysis_obj["Contributors Count"] = contributorCount
        self.files_analysis_obj["Minor Contributors Count"] = minorContributorCount

    def linesCount(self):
        metric = LinesCount(path_to_repo = self.repoDir,
                            since = self.firstCommit,
                            to = self.lastCommit)

        added_count = metric.count_added()
        removed_count = metric.count_removed()

        addedLines = []
        removedLines = []
        totalLinesAdded = 0
        totalLinesRemoved = 0

        for key, value in added_count.items():
            if key in self.fileNames:
                addedLines.append(value)
            totalLinesAdded = totalLinesAdded + value

        for key, value in removed_count.items():
            if key in self.fileNames:
                removedLines.append(value)
            totalLinesRemoved = totalLinesRemoved + value

        self.files_analysis_obj["Lines Added"] = addedLines
        self.files_analysis_obj["Lines Removed"] = removedLines

        self.general_repo_analysis["Number of Lines Added"] = totalLinesAdded
        self.general_repo_analysis["Number of Lines Removed"] = totalLinesRemoved

    def codeChurn(self):
        metric = CodeChurn(path_to_repo = self.repoDir,
                        since = self.firstCommit,
                        to = self.lastCommit)

        files_count = metric.count()
        files_max = metric.max()
        files_avg = metric.avg()

        maxChurn = []
        avgChurn = []

        for key, value in files_max.items():
            if key in self.fileNames:
                maxChurn.append(value)

        for key, value in files_avg.items():
            if key in self.fileNames:
                avgChurn.append(value)

        self.files_analysis_obj["Max Code Churn"] = maxChurn
        self.files_analysis_obj["Average Code Churn"] = avgChurn

    def contributorsExperience(self):
        metric = ContributorsExperience(path_to_repo = self.repoDir,
                                        since = self.firstCommit,
                                        to = self.lastCommit)
        files = metric.count()

        highestContributor = []

        for key, value in files.items():
            if key in self.fileNames:
                highestContributor.append(value)
                
        self.files_analysis_obj["Highest Contributor % of Lines"] = highestContributor

    def hunksCount(self):
        metric = HunksCount(path_to_repo = self.repoDir,
                            since = self.firstCommit,
                            to= self.lastCommit)

        files = metric.count()

        hunksCount = []

        for key, value in files.items():
            if key in self.fileNames:
                hunksCount.append(value)
                
        self.files_analysis_obj["Hunks Count"] = hunksCount

    def changeSet(self):
        metric = ChangeSet(path_to_repo = self.repoDir,
                    since= self.firstCommit,
                    to= self.lastCommit)

        maximum = metric.max()
        average = metric.avg()

        self.general_repo_analysis["Max Change Set"] = maximum
        self.general_repo_analysis["Average Change Set"] = average

    def contribsPerAuthor(self):


        contributionsPerContributor = {}
        authors = []
        contributions = []
        commitCounter = 0

        for commit in Repository(self.repoDir, since=self.firstCommit, to=self.lastCommit).traverse_commits():
            author = commit.committer.name

            if not author in contributionsPerContributor:
                contributionsPerContributor[author] = 1
            else:
                contributionsPerContributor[author] = contributionsPerContributor[author] + 1
            
            commitCounter = commitCounter + 1

        for key, value in contributionsPerContributor.items():
            authors.append(key)
            contributions.append(value)

        
        self.authorsObj["Contributor"] = authors
        self.authorsObj["Contributions"] = contributions

        self.general_repo_analysis["Total Number of Commits"] = commitCounter

    def fileGeneration(self):

        df = pd.DataFrame(self.files_analysis_obj)
        df.to_csv(self.dataDir+"/files_analysis.csv", index = False)

        contributionsPerCommitterDF = pd.DataFrame(self.authorsObj)
        contributionsPerCommitterDF.to_csv(self.dataDir +"/contributions_per_contributor.csv", index = False)

        generalAnalysisDF = pd.DataFrame(self.general_repo_analysis, index=[0])
        generalAnalysisDF.to_csv(self.dataDir +"/general_analysis.csv", index = False)

    def main(self):
        print("Analyizing commits per date...")
        self.commitsPerDate()

        print("Analyizing contributor count...")
        self.contributorsCount()

        print("Analyizing lines count...")
        self.linesCount()
        
        print("Analyizing code churn...")
        self.codeChurn()

        print("Analyizing contributor experience...")
        self.contributorsExperience()

        print("Analyizing hunks count...")
        self.hunksCount()

        print("Analyizing change set...")
        self.changeSet()

        print("Analyizing contributions per contributor")
        self.contribsPerAuthor()

        print("Generating files ...")
        self.fileGeneration()
