package Business;

import Presentation.Chef;

import java.util.*;

/**
 * @invariant isWellFormed()
 */

public class Restaurant implements java.io.Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    public List<MenuItem> menu =new ArrayList();
    public Map<Order, ArrayList<MenuItem>> myMap =new HashMap<Order, ArrayList<MenuItem>>();
    Chef chef;

    public Restaurant() {
    }
    public void setChef(Chef chef) {
        this.chef = chef;
    }

    protected boolean isWellFormed(){
        int n=0;
        final Iterator<MenuItem> it = menu.iterator();
        while (it.hasNext()) {
            n++;
        }
        if(menu.get(n)!=null)
            return false;
        if(it.hasNext())
            return false;
        return true;
    }

    /**
     *  adds a new item at the end of the list
     * @pre newMenuItem!=null
     * @post   getSize() == getSize()@pre + 1 */
    public void addToMenu (MenuItem newMenuItem){
        assert newMenuItem!=null;
        assert isWellFormed();
        int sizePre=menu.size();
        menu.add(newMenuItem);
        int sizePost=menu.size();
        assert sizePost==sizePre+1;
        assert isWellFormed();
        System.out.println(newMenuItem+ " added!");
    }

    /**
     *  deletes an item from list if found
     * @pre menuItemToBeDeleted!=null
     * @post   getSize() <= getSize()@pre + 1 */

    public void removeFromMenuByName (String menuItemToBeDeleted){
        assert menuItemToBeDeleted!=null;
        assert isWellFormed();
        int sizePre=menu.size();

        for(MenuItem a:menu){
            a.removeFromRecipeByName(menuItemToBeDeleted);
        }
        int sizePost=menu.size();
        assert sizePost<=sizePre+1;
        assert isWellFormed();

    }
    public void createOrder(Order order, ArrayList<MenuItem> items){
        myMap.put(order,items);
        notifyChef(items);
    }
    public void notifyChef(ArrayList<MenuItem> items){
        chef.update(items);
    }

}
