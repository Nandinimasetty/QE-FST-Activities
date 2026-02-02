from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
import time

driver = webdriver.Firefox()
driver.get("https://training-support.net/webelements/selects")
driver.maximize_window()

print("Page Title:", driver.title)

multi_select_element = driver.find_element(By.XPATH, "/html/body/div/main/div/div/div/div/section//select")

multi_select = Select(multi_select_element)

options = multi_select.options

real_options = options[1:]

print("Total number of options:", len(real_options))

multi_select.select_by_index(2)
multi_select.select_by_index(3)
multi_select.select_by_index(4)

print("All options in Single Select:")
for option in real_options:
    print(option.text)

time.sleep(2)
driver.quit()


