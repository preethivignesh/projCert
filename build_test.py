from selenium import webdriver
from selenium.webdriver.chrome.options import Options
import time

options = Options();
options.add_argument("--headless");
options.binary='/usr/bin/chromium-browser'
driver_path='/usr/bin/chromedriver'
browser = webdriver.Chrome(chrome_options=options) #,executable_path=driver_path); commenting as will try to install desired chromedriver in default path and run the case
time.sleep(120)
browser.get("http://ec2-54-226-38-2.compute-1.amazonaws.com:8000/");
time.sleep(10)
link = browser.find_element_by_link_text('About Us')
link.click();
time.sleep(1)
text = 'This is about page.'
assert browser.page_source.find(text)
browser.quit()
