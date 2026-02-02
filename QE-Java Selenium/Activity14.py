from selenium import webdriver
from selenium.webdriver.common.by import By
import time

driver = webdriver.Firefox()

driver.get("https://training-support.net/webelements/tables")
driver.maximize_window()

print("Page Title:", driver.title)

table_xpath = "/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr"

rows = driver.find_elements(By.XPATH, table_xpath)
row_count = len(rows)

columns = driver.find_elements(By.XPATH,"/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr[1]/td")
column_count = len(columns)

print("Number of Rows:", row_count)
print("Number of Columns:", column_count)

before_sort_book = driver.find_element(By.XPATH,"/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr[5]/td[2]")
print("5th Row Book Name Before Sorting:", before_sort_book.text)

price_header = driver.find_element(By.XPATH,"/html/body/div/main/div/div/div/div/div[2]/table/thead/tr/th[5]")
price_header.click()

time.sleep(2)

print("Sorted Price Values:")

price_cells = driver.find_elements(By.XPATH,"/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr/td[5]")

for price in price_cells:
    print(price.text)

after_sort_book = driver.find_element(
    By.XPATH,
    "/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr[5]/td[2]"
)
print("5th Row Book Name After Sorting:", after_sort_book.text)

driver.quit()
