package bitcamp.java106.pms.dao;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class AbstractDao<E> {
    
    protected LinkedList<E> collection = new LinkedList<>();
    
    public void insert(E value) {
        collection.add(value);
    }
    
    public Iterator<E> list() {
        return collection.iterator();
    }
    
    public E get(Object key) {
        int index = this.indexOf(key);
        if (index == -1)
            return null;
        return collection.get(index);
    }
    
    public void update(int index, E value) {
        collection.set(index, value);
    }
    
    public void delete(Object key) {
        int index = this.indexOf(key);
        if (index == -1)
            return;
        collection.remove(index);
    }
    
    // 서브 클래스를 만들 때 반다시 다음 메서드를 정의할 것을 강제한다.
    // 왜냐하면 다음 메서드는 get(), update(), delete()에서 사용하기 때문에
    // 반드시 정의되어 있어야 한다.
    public abstract int indexOf(Object key);
}

//ver 22 - generalization을 통해 클래스 추가







