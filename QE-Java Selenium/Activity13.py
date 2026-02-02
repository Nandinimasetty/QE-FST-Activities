from selenium import webdriver
from selenium.webdriver.common.by import By

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

print("Third Row Values:")

third_row = driver.find_elements(By.XPATH,"/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr[3]/td")

for cell in third_row:
    print(cell.text)

cell_2_2 = driver.find_element(By.XPATH,"/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]")
print("2nd Row 2nd Column:", cell_2_2.text)

driver.quit()
