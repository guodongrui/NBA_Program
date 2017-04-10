package nba.test;

import nba.model.Arena;
import nba.model.ArenaTeam;
import nba.model.Location;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArenaTest {
  private static Arena arena;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    arena = new Arena("AirCanadaCentre", 1999, 15);
  }

  @Test
  // Arena是否相等取决于球场名字和球场诞生年份，与年龄无关
  public void ArenaEqualTest() {
    Assert.assertEquals(arena, arena);

    Arena arena2 = new Arena("AirCanadaCentre", 1999, 15);
    Assert.assertEquals(arena, arena2);

    arena2 = new Arena("AirCanadaCentre", 1999, 16);
    Assert.assertEquals(arena, arena2);
  }

  @Test
  public void ArenaNotEqualTest() {
    Arena arena2 = new Arena();
    Assert.assertNotEquals(arena, arena2);

    arena2 = new Arena("another_areaName", 1999, 15);
    Assert.assertNotEquals(arena, arena2);

    arena2 = new Arena("AirCanadaCentre", 1998, 15);
    Assert.assertNotEquals(arena, arena2);
  }

  @Test
  public void ArenaAddLocationTest() {
    Location location = new Location();
    arena.addLocation(location);
    Assert.assertEquals(1, arena.getLocations().size());

    location = new Location(1996, 1997, "TorontoON", "AirCanadaCentre", 19500);
    arena.addLocation(location);
    Assert.assertEquals(2, arena.getLocations().size());

    location = new Location();
    arena.addLocation(location);
    Assert.assertEquals(2, arena.getLocations().size());
  }

  @Test
  public void ArenaAddArenaTeamTest() {
    ArenaTeam arenaTeam = new ArenaTeam();
    arena.addArenaTeam(arenaTeam);
    Assert.assertEquals(1, arena.getArenaTeams().size());

    arenaTeam = new ArenaTeam(1996, 1997, "Toronto Raptors", "AirCanadaCentre");
    arena.addArenaTeam(arenaTeam);
    Assert.assertEquals(2, arena.getArenaTeams().size());

    arenaTeam = new ArenaTeam();
    arena.addArenaTeam(arenaTeam);
    Assert.assertEquals(2, arena.getArenaTeams().size());
  }
}
