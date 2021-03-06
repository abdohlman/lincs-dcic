package org.flowcyt.cfcs;
// CFCSDatatypeByte.java

/* ------------------------------------------------------------------------- *\
This software and documentation are provided 'as is' and Tree Star, Inc., its
contractors and partners specifically disclaim all other warranties, expressed
or implied, including but not limited to implied warranties of merchantability
and fitness for a particular purpose, or during any particular date range.

By using this software, you are agreeing to these limits of liability, and to
hold Tree Star harmless for any information, accurate or erroneous, that might
be generated by the program.  This software is intended for research use only.

Christopher Lane <cdl@best.classes> for Tree Star  1/14/2002      Copyright 2002
\* ------------------------------------------------------------------------- */


import java.io.DataOutputStream;
import java.io.IOException;

public final class CFCSDatatypeByte extends CFCSDatatypeBinary
{

    // --------------------------------------------------------------------

    public final void readData(final int index, final byte[][] cinch)
    {
        final byte[] row = new byte[cinch.length];

        final boolean maskable = sizing.isRangeMaskable();
        final int[] masks = (maskable) ? sizing.getRangeMasks() : null;

        for (int cell = 0; cell < cinch.length; cell++)
        {
            int datum = (cinch[cell][0] & 0xff);

            if (maskable)
                datum &= masks[cell];

            row[cell] = (byte) datum;
        }

        if (index == data.size())
            data.add(row);
        else
            data.set(index, row);
    }

    // --------------------------------------------------------------------

    public final void writeData(final int index, final int count, final DataOutputStream stream)
    {
        final byte[] row = (byte[]) data.get(index);

        try
        {
            for (int i = 0; i < count; i++)
            {
                stream.writeByte(row[i]);
            }
        }
        catch (IOException exception)
        {
            throw new CFCSError(CFCSIOError, exception);
        }
    }

    // --------------------------------------------------------------------

    public final void getData(final int index, final byte[] array)
    {
        final byte[] row = (byte[]) data.get(index);

        if (array.length < row.length)
        {
            throw new CFCSError(CFCSInsufficientSpace, array.length);
        }

        System.arraycopy(row, 0, array, 0, row.length);
    }

    public final void getData(final int index, final short[] array)
    {
        final byte[] row = (byte[]) data.get(index);

        if (array.length < row.length)
        {
            throw new CFCSError(CFCSInsufficientSpace, array.length);
        }

        for (int i = 0; i < row.length; i++)
            array[i] = (short) (row[i] & 0xff);
    }

    public final void getData(final int index, final int[] array)
    {
        final byte[] row = (byte[]) data.get(index);

        if (array.length < row.length)
        {
            throw new CFCSError(CFCSInsufficientSpace, array.length);
        }

        for (int i = 0; i < row.length; i++)
            array[i] = (row[i] & 0xff);
    }

    // --------------------------------------------------------------------

    public final void setData(final int index, final byte[] array)
    {
        final byte[] row = (byte[]) data.get(index);

        System.arraycopy(array, 0, row, 0, array.length);
    }

    public final void setData(final int index, final short[] array)
    {
        final byte[] row = (byte[]) data.get(index);

        for (int i = 0; i < row.length; i++)
            row[i] = (byte) array[i]; // information loss

        data.add(row);
    }

    public final void setData(final int index, final int[] array)
    {
        final byte[] row = (byte[]) data.get(index);

        for (int i = 0; i < row.length; i++)
            row[i] = (byte) array[i]; // information loss

        data.add(row);
    }

    // --------------------------------------------------------------------

    public final void addData(final byte[] array)
    {
        final byte[] row = new byte[array.length];

        System.arraycopy(array, 0, row, 0, array.length);

        data.add(row);
    }

    public final void addData(final short[] array)
    {
        final byte[] row = new byte[array.length];

        for (int i = 0; i < row.length; i++)
            row[i] = (byte) array[i]; // information loss

        data.add(row);
    }

    public final void addData(final int[] array)
    {
        final byte[] row = new byte[array.length];

        for (int i = 0; i < row.length; i++)
            row[i] = (byte) array[i]; // information loss

        data.add(row);
    }

    // --------------------------------------------------------------------

}
