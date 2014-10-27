package cc.protea.mathlib;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MathTest extends TestCase
{
    public static Test suite() {
        return new TestSuite( MathTest.class );
    }

    public void test() {
        assertEquals( 7, Math.add(3, 4) );
    }
}
