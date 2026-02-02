import math

def test_sort():
    num=25
    assert math.sqrt(num)==5
def testsquare():
    num=7
    assert num*num==40
def testquality():
    assert 10==11
#Tests must be in the./Tests folder
#Test file shoul start or end with "test"
#Tes functions should start with "test"pytest
#pytest tests/my_second_test.py -k sqrt
