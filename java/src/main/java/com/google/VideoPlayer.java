package com.google;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class VideoPlayer {

  private final VideoLibrary videoLibrary ;
  private Boolean pause = false;

  List<String> list = new ArrayList<String>() ;
  private  final Video currentVideo = null;

  private List <Video> videos = new VideoLibrary().getVideos() .stream()
          .sorted(Comparator.comparing(Video :: getTitle))
          .collect(Collectors.toList());

//  private final  Video video;

  public VideoPlayer() {
//    this.video = new Video();
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    for (int i = 0; i < videoLibrary.getVideos().size(); i++) {
      System.out.println(videoLibrary.getVideos().get(i).getTitle() + ")" +
              videoLibrary.getVideos().get(i).getVideoId() + ")"  + "["  + videoLibrary.getVideos().get(i).getTags()+"]");

    }


  }

  public void playVideo(String videoId) {
    Video video = videoLibrary.getVideo(videoId);
    if (video == null) {
      System.out.println("Cannot stop video: No video is currently playing");
    }
    else if(list.size() > 0) {
      System.out.println("Stopping video: " + list.get(0));
      list.remove(0);
      list.add(videoLibrary.getVideo(videoId).getTitle());
    } else {
      list.add(videoLibrary.getVideo(videoId).getTitle());
    }
    System.out.println("Playing video: " + videoLibrary.getVideo(videoId).getTitle());
  }
  public void stopVideo() {
    String videoId = videoLibrary.getVideos().get(0).getVideoId();
    Video video = videoLibrary.getVideo(videoId);

     if(list.size() > 0) {
      System.out.println("Stopping video: " + list.get(0));
      list.remove(0);
    }else {
      System.out.println("Cannot stop video: No video is currently playing");

    }
  }

  public void playRandomVideo() {
    Random r = new Random();
    int randomVideoIndex = r.nextInt(videos.size());
    pause = false;
    if(currentVideo != null){
      stopVideo();
      playVideo(videos.get(randomVideoIndex).getVideoId());
    } else {
      playVideo(videos.get(randomVideoIndex).getVideoId());
    }
  }

  public void pauseVideo() {
    if(currentVideo != null){
      if(!pause){
        pause = true;
        System.out.println("Pausing video: " + currentVideo.getTitle());
      } else if (pause){
        System.out.println("Video already paused: " + currentVideo.getTitle());
      }
    }else{
      System.out.println("Cannot pause video: No video is currently playing");
    }
  }


  public void continueVideo() {
    if(currentVideo != null){
      if(pause){
        System.out.println("Continuing video: " + currentVideo.getTitle());
        pause = false;
      } else {
        System.out.println("Cannot continue video: Video is not paused");
      }

    } else{
      System.out.println("Cannot continue video: No video is currently playing");
    }
  }

  public void showPlaying() {
    if(currentVideo != null){
      String pauseStatus;
      if(pause){
        pauseStatus = " - PAUSED";
      } else{
        pauseStatus = "";
      }
      System.out.println("Currently playing: " + currentVideo.getTitle() + " (" + currentVideo.getVideoId() + ") [" + currentVideo.getTags().stream().collect(Collectors.joining(" ")) + "]"+ pauseStatus);
    } else{
      System.out.print("No video is currently playing");
    }
  }


  public void createPlaylist(String playlistName) {
    System.out.println("createPlaylist needs implementation");
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}