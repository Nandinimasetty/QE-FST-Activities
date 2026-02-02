import pytest
a=5
b=5
def testsum():
    assert a+b==10
def testsub():
    assert a-b==0
def testmul():
    assert a*b==25
def testdiv():
    assert a/b==1

def sum(a,b):
    return a+b 