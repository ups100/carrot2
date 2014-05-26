package org.carrot2.clustering.suffixtree;

public final class CharacterSequence implements ISequence
{
    public final CharSequence value;

    public CharacterSequence(CharSequence chs)
    {
        this.value = chs;
    }

    public int size()
    {
        return value.length();
    }

    public int objectAt(int i)
    {
        return value.charAt(i);
    }
}