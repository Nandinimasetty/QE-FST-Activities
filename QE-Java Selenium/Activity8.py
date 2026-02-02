from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Firefox()
driver.get("https://training-support.net/webelements/mouse-events")
driver.maximize_window()

print(driver.title)

actions = ActionChains(driver)
wait = WebDriverWait(driver, 10)

cargo_lock = driver.find_element(By.CSS_SELECTOR, ".file:nth-of-type(1)")

cargo_toml = driver.find_element(By.CSS_SELECTOR, ".file:nth-of-type(2)")

src = driver.find_element(By.CSS_SELECTOR, ".file:nth-of-type(3)")

target = driver.find_element(By.CSS_SELECTOR, ".file:nth-of-type(4)")

actions.click(cargo_lock) \
       .move_to_element(cargo_toml) \
       .click() \
       .perform()

print(driver.find_element(By.ID, "result").text)

actions.double_click(src) \
       .context_click(target) \
       .perform()

wait.until(EC.visibility_of_element_located((By.CSS_SELECTOR, "li.w-full:nth-of-type(1)")))

open_button = driver.find_element(By.CSS_SELECTOR, "li.w-full:nth-of-type(1)")

actions.click(open_button).perform()

print(driver.find_element(By.ID, "result").text)

driver.quit()








