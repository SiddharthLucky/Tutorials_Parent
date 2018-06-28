using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _4_Lambda_Operator
{
    class Program
    {
        delegate int MyDelegate(int i);

        static void Main(string[] args)
        {
            //  MyDelegate my_method = x => x * x;
            MyDelegate my_method = t => t * t;

            int result = my_method(3);
            Console.WriteLine(result);
        }
    }
}
