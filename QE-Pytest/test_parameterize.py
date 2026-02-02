#Test parametraziation 
#@pytest.mark.parametrize
import pytest 
import pandas as pd

def get_csv_data():
    df=pd.read_csv("./test_input.csv")
    return list(df.itertuples(index=False,name=None))

@pytest.mark.parametrize("val, expected_output",[(1,11),(2,22),(3,33)])
def test_multiply_11(val,expected_output):
    assert 11 * val == expected_output