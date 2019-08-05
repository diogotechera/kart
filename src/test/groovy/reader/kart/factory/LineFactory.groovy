package reader.kart.factory

class LineFactory {

    static def VALID = '23:49:08.277      038 – F.MASSA                           1\t\t1:02.852                        44,275'
    static def LESS_THAN_FIVE_VALUES = '038 – F.MASSA                           1\t\t1:02.852                        44,275'
    static def MORE_THAN_FIVE_VALUES = 'FAIL      23:49:08.277      038 – F.MASSA                           1\t\t1:02.852                        44,275'
    static def MORE_THAN_TWO_RACE_INFO = '23:49:08.277      038 – F.MASSA – Ferrari                           1\t\t1:02.852                        44,275'
    static def LESS_THAN_TWO_RACE_INFO = '23:49:08.277      F.MASSA                           1\t\t1:02.852                        44,275'
    static def INVALID_TIME =  '25:49:08.277      038 – F.MASSA                           1\t\t1:02.852                        44,275'
    static def INVALID_LAP_NUMBER = '23:49:08.277      038 – F.MASSA                           NaN\t\t1:02.852                        44,275'
    static def INVALID_AVERAGE_SPEED = '23:49:08.277      038 – F.MASSA                           1\t\t1:02.852                        NaN'
    static def LAP_TIME_WITH_HOUR = '23:49:08.277      038 – F.MASSA                           1\t\t13:01:02.852                        44,275'
    static def LAP_TIME_WITHOUT_MILLISECONDS = '23:49:08.277      038 – F.MASSA                           1\t\t1:02                        44,275'
    static def INVALID_LAP_TIME = '23:49:08.277      038 – F.MASSA                           1\t\t89:02.852                        44,275'

}
