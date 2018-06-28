using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _3_Generic_Delegates
{
    class Program
    {
        // 1. Define the delegate
        public delegate T DoMath<T>(T a, T b);

        // 2. Write the handler method
        public static int AddNumbers(int a, int b)
        {
            return a + b;
        }
        public static int MultiplyNumbers(int a, int b)
        {
            return a * b;
        }

        static void Main(string[] args)
        {
            int result = 0;
            int a = 4;
            int b = 5;

            Console.WriteLine(AddNumbers(a, b));

            // 3. Create an instance of the delegate
            DoMath<int> operation = new DoMath<int>(AddNumbers);

            // 4. Use the delegate like a method.
            result = operation(a, b);
            Console.WriteLine(result);

            operation = MultiplyNumbers;
            result = operation(a, b);
            Console.WriteLine(result);




        }
    }
}
