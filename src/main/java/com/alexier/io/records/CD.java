package com.alexier.io.records;

import java.time.Year;
import java.util.Comparator;
import java.util.List;

/**
 * Las clases Records son un nuevo tipo de clase implementada desde la version 14 de JAVA  y que ayuda a los
 * programadores a desarrollar codigo menos "verbose" es decir, con menos lineas de codigo y mas legible.
 * Al implementar records quiere decir que los datos que usaras aqui seran inmutables, por lo que no podrás
 * agregar metodos para setear la informacion.
 *
 * Recuerda que la finalidad de este recurso es solo para soluciones donde requieras usar datos inmutables
 * como en DTO's.
 *
 * @link <a href="https://openjdk.org/jeps/395">See more</a>
 * @param artist
 * @param title
 * @param noOfTracks
 * @param year
 * @param genre
 */
public record CD(String artist, String title, int noOfTracks, Year year, Genre genre) implements Comparable<CD> {
  // metodos adicionales
  public boolean isPop() { return this.genre == Genre.POP; }
  public boolean isJazz() { return this.genre == Genre.JAZZ; }
  public boolean isOther() { return this.genre ==  Genre.OTHER; }

  // implementacion toString
  @Override
  public String toString() {
    return String.format("<%s, \"%s\", %d, %s, %s>", this.artist, this.title, this.noOfTracks, this.year, this.genre);
  }

  // comparacion por artista, titulo, numero de temas, anio y genero
  @Override
  public int compareTo(CD other) {
    return Comparator.comparing(CD::artist)
                      .thenComparing(CD::title)
                      .thenComparing(CD::noOfTracks)
                      .thenComparing(CD::year)
                      .thenComparing(CD::genre)
                      .compare(this, other);
  }

  // generacion manual de algunos CD's para consultar
  public static final CD cd0 = new CD("Alexis Vazquez", "OCA Java 17", 12, Year.of(2024), Genre.OTHER);
  public static final CD cd1 = new CD("Jose Morales", "OCA Java 11", 11, Year.of(2024), Genre.OTHER);
  public static final CD cd2 = new CD("Myles Kennedy", "Apocaliptic Love", 13, Year.of(2017), Genre.POP);
  public static final CD cd3 = new CD("Frankie Ruiz", "Tributo a un sonero", 9, Year.of(2005), Genre.JAZZ);

  // un tamanio fijo de una lista de CD's creados en la parte de arriba.
  public static final List<CD> cds = List.of(cd0, cd1, cd2, cd3);
  // array de la lista de cds
  public static final CD[] cdArray = { cd0, cd1, cd2, cd3 };
}
