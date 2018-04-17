package interfaces;


public interface QueueInt {

  public boolean isEmpty();
  public Object getFrontElement();
  public Object getRearElement();
  public void put(Object theObject);
  public Object remove();

}