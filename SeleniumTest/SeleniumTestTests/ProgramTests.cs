using Microsoft.VisualStudio.TestTools.UnitTesting;
using SeleniumTest;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace SeleniumTest.Tests
{
    [TestClass()]
    public class ProgramTests
    {
        [TestMethod()]
        public void testFacebookTest()
        {
            // Arrange
            IWebDriver driver = new ChromeDriver();

            // For testing
            //1. Which website to hit
            String url = "https://www.facebook.com";
            driver.Navigate().GoToUrl(url);

            // Act
            //2. Which web elements you want to verify
            var emailData = driver.FindElement(By.Id("email"));
            emailData.SendKeys("testData");

            var passData = driver.FindElement(By.XPath("//input[@id=\"pass\"]"));
            if (passData == null) throw new ArgumentNullException(nameof(passData));
            passData.SendKeys("newPass");

            var loginButton = driver.FindElement(By.XPath("//*[@id='loginbutton']//input"));

            // Assert
            Assert.IsTrue(loginButton.Enabled);
            loginButton.Click();

            driver.Close();

            //Assert.Fail();
        }
    }
}