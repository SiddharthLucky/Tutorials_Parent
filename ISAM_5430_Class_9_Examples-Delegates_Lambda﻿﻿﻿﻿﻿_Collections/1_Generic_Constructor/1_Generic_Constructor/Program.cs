using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _1_Generic_Constructor
{
    class Program
    {
        static void Main(string[] args)
        {
            Vector<double> v = 
                new Vector<double>(3.0,4.0,5.0);
            Vector<double,float,float> v2 =
               new Vector<double, float, float>(3.0, 4.0F, 5.0F);
        }
    }
}
