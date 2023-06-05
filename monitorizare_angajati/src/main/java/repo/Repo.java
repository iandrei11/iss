package repo;

import model.StorableEntity;

import java.io.IOException;
import java.util.List;

public interface Repo<ID, E extends StorableEntity<ID>> {
    /**
     * Returns the list of all Entities
     * @return List of Entities
     */
    List<E> getAll();

    /**
     * Deletes an storableEntity
     * @param storableEntity E
     * @return true if the deletion was successful, false otherwise
     */
    boolean delete(E storableEntity) throws IOException;

    /**
     * Updates an storableEntity
     * @param storableEntity E
     * @return the storableEntity if it doesn't exist
     */
    E update (E storableEntity) throws IOException;

    /**
     * Saves and validates an storableEntity if it isn't already saved, throws Illegal Argument Exception otherwise
     * @param storableEntity E
     * @return storableEntity E if it is already logged in
     */
    E save(E storableEntity) throws IOException;

    /**
     * Returns the number of elements in the container
     * @return int
     */
    int size();
}
