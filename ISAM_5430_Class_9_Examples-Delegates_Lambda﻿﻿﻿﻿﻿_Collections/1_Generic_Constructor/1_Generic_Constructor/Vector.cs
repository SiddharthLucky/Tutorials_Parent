using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _1_Generic_Constructor
{
    public class Vector<T>
    {
        // fields
        private T x;
        private T y;
        private T z;

        // properties
        public T X
        {
            get { return x; }
            set { x = value; }
        }
        public T Y
        {
            get { return y; }
            set { y = value; }
        }
        public T Z
        {
            get { return z; }
            set { z = value; }
        }

        // default constructor
        public Vector()
        {
            x = default(T);
            y = default(T);
            z = default(T);
        }

        // constructor
        public Vector(T x, T y, T z)
        {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public class Vector<T1,T2,T3>
    {
        // auto-implemented properties
        public T1 x { get; set; }
        public T2 y { get; set; }
        public T3 z { get; set; }

        // constructor
        public Vector(T1 x, T2 y, T3 z)
        {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
