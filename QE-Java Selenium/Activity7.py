from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Firefox()
wait = WebDriverWait(driver, 10)

driver.get("https://training-support.net/webelements/dynamic-controls")

print("Title:", driver.title)

input_field = driver.find_element(By.XPATH, '//*[@id="textInput"]')

print("Input field enabled (before):", input_field.is_enabled())

driver.find_element(By.XPATH, '//*[@id="textInputButton"]').click()

wait.until(
    EC.element_to_be_clickable((By.XPATH, '//*[@id="textInput"]'))
)

print("Input field enabled (after):", input_field.is_enabled())

driver.quit()