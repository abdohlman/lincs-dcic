package org.flowcyt.cfcs;
// CFCSError.java

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

import java.util.HashMap;
import java.util.Map;

public final class CFCSError extends RuntimeException implements CFCSErrorCodes
{

    private static final Map errors = new HashMap();

    static
    {
        errors.put(new Integer(CFCSNoSuchBin), "CFCSNoSuchBin");
        errors.put(new Integer(CFCSInsufficientSpace), "CFCSInsufficientSpace");
        errors.put(new Integer(CFCSInsufficientData), "CFCSInsufficientData");
        errors.put(new Integer(CFCSNotImplemented), "CFCSNotImplemented");
        errors.put(new Integer(CFCSCannotModifySource), "CFCSCannotModifySource");
        errors.put(new Integer(CFCSIllegalName), "CFCSIllegalName");
        /* ... */
        errors.put(new Integer(CFCSKeywordUndefined), "CFCSKeywordUndefined");
        errors.put(new Integer(CFCSNoSuchDataSet), "CFCSNoSuchDataSet");
        errors.put(new Integer(CFCSBadSourceSet), "CFCSBadSourceSet");
        errors.put(new Integer(CFCSParametersUndefined), "CFCSParametersUndefined");
        /* ... */
        errors.put(new Integer(CFCSParameterInclassesplete), "CFCSParameterInclassesplete");
        errors.put(new Integer(CFCSInconsistentAttribute), "CFCSInconsistentAttribute");
        errors.put(new Integer(CFCSCannotModifyValue), "CFCSCannotModifyValue");
        errors.put(new Integer(CFCSInconsistentValue), "CFCSInconsistentValue");
        errors.put(new Integer(CFCSIllegalValue), "CFCSIllegalValue");
        errors.put(new Integer(CFCSBadValueConversion), "CFCSBadValueConversion");
        errors.put(new Integer(CFCSBadKeywordIndex), "CFCSBadKeywordIndex");
        errors.put(new Integer(CFCSKeywordExists), "CFCSKeywordExists");
        errors.put(new Integer(CFCSKeywordNotFound), "CFCSKeywordNotFound");
        errors.put(new Integer(CFCSIllegalSegment), "CFCSIllegalSegment");
        errors.put(new Integer(CFCSIOError), "CFCSIOError");
        errors.put(new Integer(CFCSStreamNotOpen), "CFCSStreamNotOpen");
        errors.put(new Integer(CFCSBadFCS), "CFCSBadFCS");
        /* ... */
        errors.put(new Integer(CFCSSystemError), "CFCSSystemError");
        /* ... */
        errors.put(new Integer(CFCSNoSuchParameter), "CFCSNoSuchParameter");
        errors.put(new Integer(CFCSNoSuchEvent), "CFCSNoSuchEvent");
        /* ... */
        errors.put(new Integer(CFCSFileNotCreated), "CFCSFileNotCreated");
        errors.put(new Integer(CFCSVersionNotSupported), "CFCSVersionNotSupported");
        errors.put(new Integer(CFCSFileNotFCS), "CFCSFileNotFCS");
        errors.put(new Integer(CFCSFileNotFound), "CFCSFileNotFound");
        errors.put(new Integer(CFCSStreamAlreadyOpen), "CFCSStreamAlreadyOpen");

        errors.put(new Integer(CFCSSuccess), "CFCSSuccess");

        errors.put(new Integer(CFCSNotFCSclassespliant), "CFCSNotFCSclassespliant");
        errors.put(new Integer(CFCSNetworkIOError), "CFCSNetworkIOError");
        errors.put(new Integer(CFCSSegmentNotPresent), "CFCSSegmentNotPresent");
        errors.put(new Integer(CFCSKeywordModified), "CFCSKeywordModified");
        errors.put(new Integer(CFCSOutOfRange), "CFCSOutOfRange");
        errors.put(new Integer(CFCSHistogramOutOfRange), "CFCSHistogramOutOfRange");
        /* ... */
        errors.put(new Integer(CFCSUndefinedAttribute), "CFCSUndefinedAttribute");
    }

    // --------------------------------------------------------------------

    public int errorNumber = CFCSSuccess;
    public String additionalInformation = null;
    public CFCSError nextError = null;

    // --------------------------------------------------------------------

    /* friendly */
    CFCSError()
    {
        this.errorNumber = CFCSSystemError;
    }

    // --------------------------------------------------------------------

    /* friendly */
    CFCSError(final int errorNumber)
    {
        this.errorNumber = errorNumber;
    }

    // --------------------------------------------------------------------

    /* friendly */
    CFCSError(final int errorNumber, final String additionalInformation)
    {
        this(errorNumber);
        this.additionalInformation = additionalInformation;
    }

    // --------------------------------------------------------------------

    /* friendly */
    CFCSError(final int errorNumber, final Throwable exception)
    {
        this(errorNumber, exception.getMessage());
    }

    // --------------------------------------------------------------------

    /* friendly */
    CFCSError(final int errorNumber, final int additionalInformation)
    {
        this(errorNumber, Integer.toString(additionalInformation));
    }

    // --------------------------------------------------------------------

    /* friendly */
    CFCSError(final int errorNumber, final double additionalInformation)
    {
        this(errorNumber, Double.toString(additionalInformation));
    }

    // --------------------------------------------------------------------

    /* friendly */
    CFCSError(final int errorNumber, final CFCSError nextError)
    {
        this(errorNumber);
        this.nextError = nextError;
    }

    // --------------------------------------------------------------------
    // Returns the error message text corresponding to the errorNumber.

    public final String getErrorMessage()
    {
        final Integer key = new Integer(errorNumber);

        if (errors.containsKey(key))
            return (String) errors.get(key);

        return null;
    }

    // --------------------------------------------------------------------

    public final String toString()
    {
        String message = getErrorMessage();

        if (additionalInformation != null)
            message += ": " + additionalInformation;

        return message;
    }

    // --------------------------------------------------------------------

}
