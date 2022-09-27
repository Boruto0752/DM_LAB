import math
from itertools import combinations
def readData(filename):
    f = open(filename)
    lines = f.readlines()
    transactions = []
    items = lines[0].split(',')
    for line in lines[1:]:
        transactions.append(list(map(int,line.split(','))))
    data ={
        'items':items,
        'transactions':transactions
    }
    return data

def getFreq(s,items,transactions):
    freq=0
    for t in transactions:
        temp=1
        for item in s:
            temp*=t[items.index(item)]
        if temp==1:
            freq+=1  
    return freq


def frequentItemsets(data,level,min_support):
    items = data['items']
    transactions = data['transactions']
    min_freq = math.ceil(min_support*len(transactions))
    sets = list(combinations(items,level))
    frequent_sets = []
    for s in sets:
        freq=getFreq(s,items,transactions)
        if freq>=min_freq:
            frequent_sets.append(s)
    return frequent_sets


if __name__ == '__main__':
    data=readData('itemsets.csv')
    print(frequentItemsets(data,2,0.5))