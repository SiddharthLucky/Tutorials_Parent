using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2_Delegates
{
    class Program
    {
        // 1. Define the delegate
        public delegate double UnitConversion(double from);

        // 2. Write the handler method
        public static double FeetToInches(double feet)
        {
            return feet * 12.0;
        }
        public static double YardToInches(double yards)
        {
            return yards * 36.0;
        }

        static void Main(string[] args)
        {
            // 3. Create an instance of the delegate
            UnitConversion doConvert = new UnitConversion(FeetToInches);

            Console.Write("Enter number of feet: ");
            string input = Console.ReadLine();
            double feet = Convert.ToDouble(input);

            // 4. Use the delegate like a method.
            double inches = doConvert(feet);

            Console.WriteLine("{0} feet is {1} inches", feet, inches);

            doConvert = YardToInches;
            inches = doConvert(2.0);
            Console.WriteLine("{0} yards is {1} inches", 2.0, inches);

        }
    }
}
