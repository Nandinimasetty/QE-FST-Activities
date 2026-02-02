from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
import time

driver = webdriver.Firefox()
driver.get("https://training-support.net/webelements/selects")
driver.maximize_window()

print("Page Title:", driver.title)

multi_select = Select(driver.find_element(By.XPATH, "/html/body/div/main/div/div/div/div/section/div[2]/select"))

driver.find_element(By.XPATH,"/html/body/div/main/div/div/div/div/section/div[2]/select/option[2]").click()

multi_select.select_by_index(3)
multi_select.select_by_index(4)
multi_select.select_by_index(5)

driver.find_element(By.XPATH,"/html/body/div/main/div/div/div/div/section/div[2]/select/option[11]").click()

multi_select.deselect_by_index(4)

time.sleep(2)
driver.quit()

