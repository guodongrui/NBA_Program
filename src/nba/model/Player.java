package nba.model;

import java.util.LinkedList;
import java.util.List;

public class Player {
  private String name;// 球员姓名
  private int birth_year;// 球员生日年份
  private List<Season> seasons;// 球员参加过的赛季列表


  public Player(String name, int birth_year) {
    this.name = name;
    this.birth_year = birth_year;
    seasons = new LinkedList<Season>();
  }

  public Player() {
    this("", 0);
  }

  public void addSeason(Season season) {
    if (season != null && !seasons.contains(season)) seasons.add(season);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj != null && obj.getClass().equals(this.getClass())) {
      Player player = (Player) obj;
      return player.name.equals(name) && player.getBirth() == birth_year;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = result * 31 + name.hashCode();
    result = result * 31 + birth_year;
    return result;
  }

  public void setBirth(int year) {
    birth_year = year;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getBirth() {
    return birth_year;
  }

  public List<Season> getSeasons() {
    return seasons;
  }

  public void setSeasons(List<Season> seasons) {
    this.seasons = seasons;
  }
}
