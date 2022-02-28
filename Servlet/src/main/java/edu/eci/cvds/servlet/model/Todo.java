package edu.eci.cvds.servlet.model;


public class Todo {
    private int userId;
    private int id = 0;
    private String title;
    private boolean completed;

    
    public Todo(){

    }


    /**
     * userID
     * @return
     */
    public int getUserId() {
        return userId;
    }

    /**
     * id getter
     * @return
     */
    public int getId() {
        return id;
    }
    /**
     * title getter
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * compleated getter
     * @return
     */
    public boolean getCompleted(){
        return completed;
    }

    /**
     * compleated Setter
     * @param completed
     */
    
    public void setCompleated(boolean completed) {
        this.completed = completed;
    }
    /**
     * id Setter
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * title Setter
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * userID Setter
     * @param userID
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
