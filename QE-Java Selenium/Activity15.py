from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Firefox()

driver.get("https://training-support.net/webelements/dynamic-attributes")
driver.maximize_window()

print("Page Title:", driver.title)

wait = WebDriverWait(driver, 10)

full_name_value = "Nandini Masetty"
email_value = "Nandini@gmail.com"
event_date_value = "25/12/2026"   
details_value = "Selenium Dynamic Attributes Testing"

wait.until(EC.visibility_of_element_located((By.XPATH, "//input[contains(@id,'full-name')]"))).send_keys(full_name_value)

driver.find_element(By.XPATH, "//input[contains(@id,'email')]").send_keys(email_value)

driver.find_element(By.XPATH, "//*[@id='signInForm']/input[3]").send_keys(event_date_value)

driver.find_element(By.XPATH, "//textarea[contains(@id,'additional-details')]").send_keys(details_value)

driver.find_element(By.XPATH, "//*[@id='signInForm']/button").click()

success_message = wait.until(EC.presence_of_element_located((By.XPATH, "//*[@id='action-confirmation']")))

print("Your event has been scheduled!", success_message.text)

driver.quit()


