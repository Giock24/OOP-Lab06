package it.unibo.oop.lab.collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	//private final String firstName;
    //private final String lastName;
    //private final String username;
	private final Map<String, Set<U>> network;
	private final List<U> followers;
	
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
	 public SocialNetworkUserImpl(final String name, final String surname, final String user) {
		 super(name, surname, user, -1);
		 this.network = new HashMap<>();
		 this.followers = new ArrayList<>();
	 }

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
        this.network = new HashMap<>();
        this.followers = new ArrayList<>();
    }

    /*
     * [METHODS]
     * 
     * Implements the methods below
     */

    @Override
    public boolean addFollowedUser(final String circle, final U user) {
       	Set<U> group = new HashSet<>();
    	
    	//indipendentemente da tutto aggiunge un Follower alla lista
    	this.followers.add(user);
    	
    	if (!this.network.containsKey(circle)) {
    		group.add(user);
    		this.network.put(circle, group);
    		return true;
    	} else if (this.network.containsKey(circle)) {
    		group = this.network.get(circle);
    		group.add(user);
    		return true;
    	} else {
     		return false;
    	}
    }

    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
    	Collection<U> usersInGroup = new HashSet<>();
    	
    	if (this.network.containsKey(groupName)) {
    		usersInGroup.addAll(this.network.get(groupName));
    		return usersInGroup;
    	} else {
    		System.out.println("This group doesn't exist!");
    		return usersInGroup;
    	}
    }

    @Override
    public List<U> getFollowedUsers() {
        return this.followers;
    }

    
}
