from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time

driver = webdriver.Firefox()
driver.maximize_window()

wait = WebDriverWait(driver, 10)

driver.get("https://training-support.net/webelements/tabs")

print("Main Page Title:", driver.title)

parent_handle = driver.current_window_handle
print("Parent Handle:", parent_handle)

open_tab_xpath = "//button[text()='Open A New Tab']"

driver.find_element(By.XPATH, open_tab_xpath).click()

wait.until(EC.number_of_windows_to_be(2))

for handle in driver.window_handles:
    if handle != parent_handle:
        driver.switch_to.window(handle)
        break

print("First New Tab Title:", driver.title)

message = wait.until(EC.visibility_of_element_located((By.XPATH, "/html/body/div/main/div/div/div/div/h2"))).text

print("First New Tab Message:", message)

time.sleep(2)
driver.quit()
