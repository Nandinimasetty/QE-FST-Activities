from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time

driver = webdriver.Firefox()
driver.maximize_window()

wait = WebDriverWait(driver, 10)

driver.get("https://training-support.net/webelements/popups")

print("Page Title:", driver.title)

driver.find_element(By.XPATH, "//*[@id='launcher']").click()

wait.until(EC.visibility_of_element_located((By.XPATH, "//*[@id='username']")))

driver.find_element(By.XPATH, "//*[@id='username']").send_keys("admin")

driver.find_element(By.XPATH, "//*[@id='password']").send_keys("password")

print("Entered username and password")

driver.find_element(By.XPATH, "//*[@id='signInForm']/button").click()

confirmation_message = wait.until(EC.visibility_of_element_located((By.XPATH, "/html/body/div/main/div/div/div/div/div/h2"))).text

print("Confirmation Message:", confirmation_message)

time.sleep(2)
driver.quit()
