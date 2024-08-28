package com.example.GitMiningRestSever;

import ch.qos.logback.classic.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;
import java.util.List;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class GitMiningRestSeverApplication implements CommandLineRunner {

	int flag1 =0;
	@Autowired
	repoActivityCreation repoActivity;
	@Autowired
	contributionCreation contribution;
	@Autowired
	dateCreation date;
	@Autowired
	filesAnalysisCreation file;
	@Autowired
	generalAnalysisCreation general;

	private PopulateDB contributionDB = new PopulateDB("/data/contributions_per_contributor.csv");
	private PopulateDB dateDB = new PopulateDB("/data/dates.csv");
	private PopulateDB fileAnalysisDB = new PopulateDB("/data/files_analysis.csv");

	private PopulateDB repoActivityDB = new PopulateDB("/data/repo_activity_dates.csv");
	private PopulateDB generalAnalysisDB = new PopulateDB("/data/general_analysis.csv");
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(GitMiningRestSeverApplication.class, args);
	}

	void createcollections() throws IOException{

		System.out.println("Creating Databases");
		List<List<String>> result = fileAnalysisDB.populate();
		List<List<String>> result2 = generalAnalysisDB.populate();
		List<List<String>> result3 = dateDB.populate();
		List<List<String>> result4 = contributionDB.populate();
		List<List<String>> result5 = repoActivityDB.populate();

		for (int i = 0; i < result.size(); i++) {
			String s = result.get(i).toString();
			s = s.replaceAll("\\[", "").replaceAll("\\]", "");
			String[] vals = s.split(",");
			file.save(new filesAnalysisNode(Integer.toString(i),vals[0],vals[1],vals[2],vals[3],vals[4],vals[5],vals[6],vals[7],vals[8]));
		}
		for (int i = 0; i < result2.size(); i++) {
			String s = result2.get(i).toString();
			s = s.replaceAll("\\[", "").replaceAll("\\]", "");
			String[] vals = s.split(",");
			general.save(new generalAnalysisNode(Integer.toString(i),vals[0],vals[1],vals[2],vals[3],vals[4]));
		}
		for (int i = 0; i < result3.size(); i++) {
			String s = result3.get(i).toString();
			s = s.replaceAll("\\[", "").replaceAll("\\]", "");
			String[] vals = s.split(",");
			date.save(new dateNode(Integer.toString(i), vals[0], vals[1]));
		}
		for (int i = 0; i < result4.size(); i++) {
			String s = result4.get(i).toString();
			s = s.replaceAll("\\[", "").replaceAll("\\]", "");
			String[] vals = s.split(",");
			contribution.save(new contributorNode(Integer.toString(i),vals[0],vals[1]));
		}

		for(int i = 0; i < result5.size(); i++) {
			String s = result5.get(i).toString();
			s = s.replaceAll("\\[", "").replaceAll("\\]", "");
			String[] vals = s.split(",");
			repoActivity.save(new repoActivityDateNode(Integer.toString(i), vals[0]));
		}

	}
	public Thread thread = new Thread(new Runnable() {

		public void run() {
			int count = 0;
			while (true) {

				System.out.println("In the run method");

				try {
					thread.sleep(3000);
					createcollections();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				} catch (IOException e) {
					count++;
				}

				if(count ==1){
					break;
				}
			}

		}
	});

	@Override
	public void run(String... args) throws Exception {
		thread.start();

	}
}
