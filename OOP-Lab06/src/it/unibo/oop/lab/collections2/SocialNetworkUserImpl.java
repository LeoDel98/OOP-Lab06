package it.unibo.oop.lab.collections2;

import java.util.*;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     * 
     * [FIELDS]
     * 
     * Define any necessary field
     * 
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     * 
     * think of what type of keys and values would best suit the requirements
     */
	final Map<String,Set<U>> map;

    /*
     * [CONSTRUCTORS]
     * 
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     * 
     * - firstName - lastName - username - age and every other necessary field
     * 
     * 2) Define a further constructor where age is defaulted to -1
     */

    /**
     * Builds a new {@link SocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
		super(name, surname, user, userAge);
        this.map = new HashMap<>();
    }
    
    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        super(name, surname, user, -1);
        this.map = new HashMap<>();
    }

    /*
     * [METHODS]
     * 
     * Implements the methods below
     */
    
    /**
     * Voglio aggiungere ad un gruppo un utente: creo un set con quel nome passato come parametro
     * Se quel set == null allora creo il set nella mappa e vi aggiungo l'utente
     * Nel caso nella mappa quel gruppo abbia già degli utenti, aggiungo solo l'User
     */
    @Override
    public boolean addFollowedUser(final String circle, final U user) {
    	Set<U> circleFriends = this.map.get(circle);
    	if (circleFriends == null) {
    		circleFriends = new HashSet<>();
    		this.map.put(circle, circleFriends);
    	}
        return circleFriends.add(user);
    }

    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        final Collection<U> usersInCircle = this.map.get(groupName);	//se nella mappa esiste in gruppo con quel nome allora ritorno tutto quel gruppo
        if (usersInCircle != null) {
        	return new ArrayList<>(usersInCircle);
        }
        
        return Collections.emptyList();
    }

    @Override
    public List<U> getFollowedUsers() {
        final Set<U> friendList = new HashSet<>();
        for (final Set<U> grp : map.values()) {
        	friendList.addAll(grp);
        }
        
        return new ArrayList<>(friendList);
    }

}
