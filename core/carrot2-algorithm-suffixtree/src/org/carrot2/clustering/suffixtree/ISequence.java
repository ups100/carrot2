package org.carrot2.clustering.suffixtree;

interface ISequence
{
    /**
     * Returns the number of elements in the sequence.
     */
    public int size();

    /**
     * Returns a unique integer code for object at index <code>i</code> (the first element
     * has 0 index).
     */
    public int objectAt(int i);
}
