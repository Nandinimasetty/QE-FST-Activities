from selenium import webdriver
from selenium.webdriver.common.by import By


driver = webdriver.Firefox()

driver.get("https://training-support.net")


about_us = driver.find_element(By.LINK_TEXT, "About Us")
about_us.click()

print(driver.title)

driver.quit()
