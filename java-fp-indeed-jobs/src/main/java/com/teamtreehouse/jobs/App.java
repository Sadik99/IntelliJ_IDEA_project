package com.teamtreehouse.jobs;

import com.teamtreehouse.jobs.model.Job;
import com.teamtreehouse.jobs.service.JobService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {

  public static void main(String[] args) {
    JobService service = new JobService();
    boolean shouldRefresh = false;
    try {
      if (shouldRefresh) {
        service.refresh();
      }
      List<Job> jobs = service.loadJobs();
      System.out.printf("Total jobs:  %d %n %n", jobs.size());
      explore(jobs);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void explore(List<Job> jobs) {
    System.out.println("debugging......!!!!!");
    printPortlandJobs(jobs);
    System.out.println();
    threeJuniorJobs(jobs);
    getCaptionStream(jobs).forEach(System.out::println);

  }

  private static void threeJuniorJobs(List<Job> jobs) {
    jobs.stream()
            .filter(App::isJunior).limit(3)
            .forEach(System.out::println);
  }

  private static boolean isJunior(Job job){

    if((job.getTitle().toLowerCase()).contains("junior")
            ||(job.getTitle().toLowerCase()).contains("jr")) return true;
     return false;
  }

  private static void printPortlandJobs(List<Job> jobs) {
    jobs.stream()
            .filter(job -> job.getState().equals("OR"))
            .filter(job -> job.getCity().equals("Portland"))
            .forEach(System.out::println);
  }

  private static List<Object> getCaptionStream(List<Job>jobs){
    return jobs.stream()
            .filter(App::isJunior)
            .map(Job::getCaption)
            .limit(3)
            .collect(Collectors.toList());
  }
  private static List<String> getCaptionImperative(List<Job>jobs){
    List<String>captions=new ArrayList<>();
    for(Job job:jobs){
      if(isJunior(job)){

        captions.add(job.getCaption());
        if(captions.size()>=3){
          break;
        }
      }
    }
    return captions;
  }

}
