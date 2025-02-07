package com.devsuperior.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

    @EmbeddedId
    private BelongingPK id = new BelongingPK();

    private Integer position;

    public Belonging() {
    }

    public Belonging(Game game, GameList list, Integer position) {
        id.setGame(game);
        id.setList(list);
        this.position = position;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
          return true;
      if (obj == null)
          return false;
      if(getClass() != obj.getClass())
          return false;
      Belonging other = (Belonging) obj;
      return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if(getClass() != obj.getClass())
//            return false;
//        BelongingPK other = (BelongingPK) obj;
//        return Objects.equals(game, other.game) && Objects.equals(list, other.list);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(game, list);
//    }
}
