from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service
from selenium.webdriver.firefox.options import Options
import time

driver = webdriver.Firefox() 

try:
    driver.get("https://training-support.net/webelements/dynamic-controls")

    print("Page Title:", driver.title)

    checkbox = driver.find_element(By.ID, "checkbox")

    print("Checkbox selected (before click):", checkbox.is_selected())

    checkbox.click()
    time.sleep(1) 
    
    print("Checkbox selected (after click):", checkbox.is_selected())

finally:
    driver.quit()
