package org.carrot2.clustering.suffixtree;


public final class IntegerSequence implements ISequence
{
    private final int [] seq;
    private final int start;
    private final int length;

    public IntegerSequence(int [] seq)
    {
        this(seq, 0, seq.length);
    }

    public IntegerSequence(int [] seq, int start, int length)
    {
        this.seq = seq;
        this.start = start;
        this.length = length;
    }

    @Override
	public int size()
    {
        return length;
    }

    @Override
	public int objectAt(int i)
    {
        return seq[start + i];
    }
}
