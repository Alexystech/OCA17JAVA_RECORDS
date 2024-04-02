package com.alexier.io;

import com.alexier.io.records.CD;

import java.util.List;

public class Main {
  public static void main(String... args) {
    List<CD> cds = CD.cds;
    cds.stream().forEach(cd -> {
      String cdToString = String.format("%s, %s, %d, %s, %s", cd.artist(), cd.title(), cd.noOfTracks(), cd.year(), cd.genre());
      System.out.println(cdToString);
    });
  }
}