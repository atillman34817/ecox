import csv
import datetime
import random

def main():
    latlongs = [
        [27.812295,-82.786255],
        [27.811866,-82.786845],
        [27.811356,-82.786588],
        [27.810792,-82.785177]]
    
    for i in range(4):
        data = []
        temp = 27.0
        
        for j in range(5000):
            temp += random.uniform(-0.1, 0.1)
            delta = datetime.timedelta(seconds=10*j)
            timestamp = '{:%Y-%m-%d %H:%M:%S}'.format(datetime.datetime.now() + delta)
            row = [timestamp, latlongs[i][0], latlongs[i][1], '%.3f' % temp]
            data.append(row)
        
        with open('sensor_' + str(i+1) + '.csv', 'w', newline = '') as f:
            writer = csv.writer(f)
            writer.writerows(data)

main()