// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Integer cache = null;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(cache != null) {
            return cache;
        } else {
            cache = iterator.next();
            return cache;
        }
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(cache != null) {
            Integer tmp = cache;
            cache = null;
            return tmp;
        } else {
            return iterator.next();
        }
    }

    @Override
    public boolean hasNext() {
        return (cache != null) || iterator.hasNext();
    }
}
