package it.ires.exam.network;

import it.ires.exam.Sim.SimCard;

import java.util.Set;

public class NetworkSimRepository {
    Set<SimCard> simCards;
    public NetworkSimRepository(Set<SimCard> simCards) {
        this.simCards = simCards;
    }
    public void addSimCard (SimCard simCard) {
        simCards.add(simCard);
    }
}
