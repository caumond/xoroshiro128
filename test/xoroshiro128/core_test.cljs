(ns xoroshiro128.core-test
 (:require
  [cljs.test :refer-macros [deftest is]]
  [xoroshiro128.long-int :as l]
  [xoroshiro128.core :as x]))

(defn rand-long
 []
 (l/long
  (* 9223372036854775807 (Math/random))))

; (deftest benchmark
;   (criterium.core/bench (rand-long))
;   (criterium.core/bench (x/rand)))

; (deftest ??xoroshiro128+--args
;  ; Check the signature of xoroshiro128+ all works as expected.
;  ; 1x 64 bit.
;  (let [seed64 (rand-long)
;        x (x/xoroshiro128+ seed64)
;        seed128 (x/seed64->seed128 seed64)]
;   (is (= seed128 (x/seed x))))
;
;  ; 2x 64 bit
;  (let [a (rand-long)
;        b (rand-long)
;        x (x/xoroshiro128+ a b)]
;   (is (= [a b] (x/seed x))))
;
;  ; 1x 128 bit vector
;  (let [seed128 [(rand-long) (rand-long)]
;        x (x/xoroshiro128+ seed128)]
;   (is (= seed128 (x/seed x))))
;
;  ; 1x UUID
;  (let [u (java.util.UUID/randomUUID)
;        seed128 [(.getMostSignificantBits u) (.getLeastSignificantBits u)]
;        x (x/xoroshiro128+ u)]
;   (is (= seed128 (x/seed x)))))

; (deftest x-rand
;   (let [seed (rand-long)
;         x   (x/xoroshiro128+ seed)
;         j   (x/jump x)
;         j'  (x/jump j)]
;     ; Check that we can seed rand properly.
;     (x/seed-rand! seed)
;     (is (= (x/rand) (x/value x)))
;     (is (= (x/rand) (x/value (x/next x))))
;     (is (= (x/rand) (x/value (x/next (x/next x)))))
;     (x/seed-rand! seed)
;     (is (= (x/rand) (x/value x)))
;     (is (= (x/rand) (x/value (x/next x))))
;     (is (= (x/rand) (x/value (x/next (x/next x)))))
;     ; Check that we can jump rand properly.
;     (x/seed-rand! seed)
;     (x/jump-rand!)
;     (is (= (x/rand) (x/value j)))
;     (x/seed-rand! seed)
;     (x/jump-rand!)
;     (x/jump-rand!)
;     (is (= (x/rand) (x/value j')))))

; (deftest ??xoroshiro128-jump
;   ; References generated by https://ideone.com/PuauK5 using the C reference implementation.
;   (let [x (x/xoroshiro128+ 3610677051444252520 -111600565950788475)
;         j1 (x/jump x)
;         j2 (x/jump (x/next j1))
;         j3 (x/jump (x/next j2))
;         j4 (x/jump (x/next j3))
;         j5 (x/jump (x/next j4))]
;     (is (= 1380011959502460548 (x/value j1)))
;     (is (= -8039967115997247744 (x/value j2)))
;     (is (= 4226878875002605666 (x/value j3)))
;     (is (= -7260350153901218819 (x/value j4)))
;     (is (= 1922911174585345600 (x/value j5))))
;
;   (let [x (x/xoroshiro128+ 990903846483086990 -9148032195894284410)
;         j1 (x/jump x)
;         j2 (x/jump (x/next j1))
;         j3 (x/jump (x/next j2))
;         j4 (x/jump (x/next j3))
;         j5 (x/jump (x/next j4))]
;     (is (= -202913253275002842 (x/value j1)))
;     (is (= -3343919899937856555 (x/value j2)))
;     (is (= 7815278568507025494 (x/value j3)))
;     (is (= -7622830828298576044 (x/value j4)))
;     (is (= 2861384012317217776 (x/value j5))))
;
;   (let [x (x/xoroshiro128+ -4009791646934021264 2482945807292523774)
;         j1 (x/jump x)
;         j2 (x/jump (x/next j1))
;         j3 (x/jump (x/next j2))
;         j4 (x/jump (x/next j3))
;         j5 (x/jump (x/next j4))]
;     (is (= 6862507382354034559 (x/value j1)))
;     (is (= 7011875142185683248 (x/value j2)))
;     (is (= -4496564143832921207 (x/value j3)))
;     (is (= 1853506959186203582 (x/value j4)))
;     (is (= -8638081920607530712 (x/value j5))))
;
;   (let [x (x/xoroshiro128+ 8408836858555572576 -8576334934951868580)
;         j1 (x/jump x)
;         j2 (x/jump (x/next j1))
;         j3 (x/jump (x/next j2))
;         j4 (x/jump (x/next j3))
;         j5 (x/jump (x/next j4))]
;     (is (= -2331108112525860358 (x/value j1)))
;     (is (= -7058988001537110731 (x/value j2)))
;     (is (= -6592145494078489880 (x/value j3)))
;     (is (= -1634515623999943417 (x/value j4)))
;     (is (= 3097860178046766537 (x/value j5))))
;
;   (let [x (x/xoroshiro128+ 1865665657046312887 -2081931776983017860)
;         j1 (x/jump x)
;         j2 (x/jump (x/next j1))
;         j3 (x/jump (x/next j2))
;         j4 (x/jump (x/next j3))
;         j5 (x/jump (x/next j4))]
;     (is (= 6193425956360965668 (x/value j1)))
;     (is (= -5684898831560071200 (x/value j2)))
;     (is (= -2065913535431491189 (x/value j3)))
;     (is (= 9075337997212788543 (x/value j4)))
;     (is (= -5025025827370910366 (x/value j5))))
;
;   (let [x (x/xoroshiro128+ 4716662714674336978 -4755215357118135582)
;         j1 (x/jump x)
;         j2 (x/jump (x/next j1))
;         j3 (x/jump (x/next j2))
;         j4 (x/jump (x/next j3))
;         j5 (x/jump (x/next j4))]
;     (is (= 9063123224574765832 (x/value j1)))
;     (is (= -8444699141156829399 (x/value j2)))
;     (is (= -908412126696469887 (x/value j3)))
;     (is (= 5890875775521162114 (x/value j4)))
;     (is (= -3787313022067243265 (x/value j5)))))

(deftest ??seed-extraction
;   ; We should be able to take a seed from any point in a sequence and seed a new
;   ; identical sequence that starts from the first point.
;   ; Xoroshiro128+
;   (let [gen-one (x/xoroshiro128+ (rand-long))
;         gen-one' (-> gen-one x/next x/next x/next)
;         a (first (x/seed gen-one'))
;         b (second (x/seed gen-one'))
;         gen-two (x/xoroshiro128+ a b)]
;     (is (=  (-> gen-two x/next x/value)
;             (-> gen-one' x/next x/value)))
;     (is (=  (-> gen-two x/next x/next x/value)
;             (-> gen-one' x/next x/next x/value))))
;
 ; Splitmix64
 (let [gen-one (x/splitmix64 (rand-long))
       gen-one' (-> gen-one x/next x/next x/next)
       a (first (x/seed gen-one'))
       gen-two (x/splitmix64 a)]
  (is
   (.equals
    (-> gen-two x/next x/value)
    (-> gen-one' x/next x/value)))
  (is
   (.equals
    (-> gen-two x/next x/next x/value)
    (-> gen-one' x/next x/next x/value)))))

(deftest ??splitmix64
  []
  (let [next-seed #(.add (l/long %) x/L-0x9E3779B97F4A7C15)
        iterator #(map x/value (iterate x/next (x/splitmix64 (l/long %))))
        longs-equal? (fn [s-1 s-2]
                      (doall
                       (map
                        #(is (.equals %1 %2))
                        (map l/long s-1)
                        (map l/long s-2))))]
    ; Just outlining a list of known-good values.
    (is
     (.equals
      (l/long "-2152535657050944081")
      (x/value (x/splitmix64 0))))

    (is
     (.equals
      (l/long "7960286522194355700")
      (x/value (x/splitmix64 (next-seed 0)))))
    (is
     (.equals
      (x/value (x/splitmix64 (next-seed 0)))
      (x/value (x/next (x/splitmix64 0)))))

    (longs-equal?
     (take 10 (iterator 0))
     ["-2152535657050944081"
      "7960286522194355700"
      "487617019471545679"
      "-537132696929009172"
      "1961750202426094747"
      "6038094601263162090"
      "3207296026000306913"
      "-4214222208109204676"
      "4532161160992623299"
      "-884877559730491226"])

    (is
     (.equals
      (l/long "-7995527694508729151")
      (x/value (x/splitmix64 1))))

    (is
     (.equals
      (l/long "-4689498862643123097")
      (x/value (x/splitmix64 (next-seed 1)))))

    (is
     (.equals
      (x/value (x/splitmix64 (next-seed 1)))
      (x/value (x/next (x/splitmix64 1)))))

    (longs-equal?
     ["-7995527694508729151"
      "-4689498862643123097"
      "-534904783426661026"
      "8196980753821780235"
      "8195237237126968761"
      "-4373826470845021568"
      "-2262517385565684571"
      "-8797857673641491083"
      "5266705631892356520"
      "-3800091893662914666"]
     (take 10 (iterator 1)))

    (is
     (.equals
      (l/long "-549842748227632346")
      (x/value (x/splitmix64 "4693323816697189744"))))

    (is
     (.equals
      (l/long "1984452702661322627")
      (x/value (xoroshiro128.core/splitmix64 "5165464252035433577"))))

    (is
     (.equals
      (l/long "8603550955848928026")
      (x/value (xoroshiro128.core/splitmix64 "-3762096910555017800"))))

    (is
     (.equals
      (l/long "2259666501077083692")
      (x/value (xoroshiro128.core/splitmix64 "3265627685425294603"))))

    ; References generated by https://ideone.com/PuauK5 using the C reference implementation.
    (longs-equal?
     ["-1034691706609893923"
      "8680904332693978080"
      "612224539874700810"
      "1493023403444147697"
      "-4971950877442337366"
      "4658924989491456893"
      "-8241183556360570177"
      "3339891364704115287"
      "1891745321218875292"
      "7882050595557362670"
      "-9127375162604566388"
      "-3569741190262511653"
      "4346649363269677585"
      "1348791259155216957"
      "-3755241545019354078"
      "-8372197932075677063"
      "1005476421853585512"
      "4863487860399772318"
      "-8076540459081623095"
      "-5848806425627354111"]
     (take 20 (iterator "8713631545574875647")))

    (longs-equal?
     ["-4244452510388952855"
      "5956223441727670834"
      "-5213410896474884335"
      "-8606047647151789358"
      "-1962840546543243000"
      "4806123284274150721"
      "-452391144067255625"
      "-8128949576161005705"
      "-7766982720124747874"
      "2442572333995175370"
      "8795907375291054885"
      "-8300047804671076982"
      "-947267881210448127"
      "-5039450819200293977"
      "712308302981280290"
      "7522540599929537755"
      "6355174942928525052"
      "5978894557897017932"
      "1384107261312862605"
      "-919695367079934955"]
     (take 20 (iterator "-1652281797047415913")))

    (longs-equal?
     ["8087921443129252442"
      "855057127608676726"
      "-6259317645692393728"
      "8635608728090513967"
      "421061866719506586"
      "1877777419215953186"
      "4368703655494729211"
      "-1556609034609545752"
      "2341270030079493298"
      "-4138133028227527398"
      "-2247435238311012618"
      "-3224698691004407592"
      "2088590171456458876"
      "-1298671274262257903"
      "1782832499389687398"
      "1761783612743519830"
      "-7698279181887729364"
      "7145871122668955989"
      "6134502485225506850"
      "-4145396449423903700"]
     (take 20 (iterator "-8225000251231588461")))

    (longs-equal?
     ["2670967931508222055"
      "-3000391555947838935"
      "8699201354616398215"
      "4677786568774967471"
      "-4447483319296117254"
      "-1295230923362471383"
      "8295783462537564258"
      "2598289853101382717"
      "6806078238418048467"
      "-3643098847711341461"
      "850647228885797518"
      "4470415377057051519"
      "6061701817095049662"
      "-1125420228581506965"
      "-8343796135060713483"
      "-8709337688951741385"
      "-6473846124213406975"
      "4547348900786126390"
      "1842410324700671551"
      "-5605188000391847805"]
     (take 20 (iterator "1208660907874351407")))

    (longs-equal?
     ["-2485330961573533924"
      "2003845614284201340"
      "8537714462879617001"
      "475936958727069082"
      "-3649477943072457787"
      "6767009688717836876"
      "-101939472702990911"
      "-5839602631113212659"
      "-6522866584845456357"
      "-7197524940719392529"
      "3174802993620206951"
      "-8589839196322619404"
      "5020282923123977254"
      "-5832226764092013228"
      "1465530971980567248"
      "-8980745324321520516"
      "8794186555272603565"
      "2088909702140509611"
      "-5077844290574236237"
      "-9009488735979577267"]
     (take 20 (iterator "-7753703826340145833")))))

; (deftest xoroshiro128+
;   []
;   ; Passing one value should run through splitmix64.
;   (let [x (x/xoroshiro128+ 1)
;         y (x/xoroshiro128+ -4689498862643123097 -534904783426661026)]
;     (is (=  -5224403646069784123
;             (x/value x)
;             (x/value y))))
;
;   (let [x (x/xoroshiro128+ 0)
;         y (x/xoroshiro128+ 7960286522194355700 487617019471545679)]
;     (is (=  8447903541665901379
;             (x/value x)
;             (x/value y))))
;
;   ; Passing two values should pass through to the algorithm.
;   (let [x (x/xoroshiro128+ 0 1)]
;     (is (= 1 (x/value x)))
;     (is (= 68719493121 (x/value (x/next x))))
;     (is (= 38280734540038433 (x/value (x/next (x/next x))))))
;
;   (let [x (x/xoroshiro128+ 1 0)]
;     (is (= 1 (x/value x)))
;     (is (= 36028865738457089 (x/value (x/next x))))
;     (is (= 2322306399469857 (x/value (x/next (x/next x))))))
;
;   (let [x (x/xoroshiro128+ 1 1)]
;     (is (= 2 (x/value x)))
;     (is (= 36028797018963968 (x/value (x/next x))))
;     (is (= 36099165897359360 (x/value (x/next (x/next x))))))
;
;   (let [x (x/xoroshiro128+ -2288729261622650145 -6926512846790308433)]
;     (is (= -9215242108412958578 (x/value x)))
;     (is (= -7532115046694008527 (x/value (x/next x))))
;     (is (= 7536573313527036548 (x/value (x/next (x/next x))))))
;
;   (let [x (x/xoroshiro128+ 6229099873966726092 6043473223518792799)]
;     (is (= -6174170976224032725 (x/value x)))
;     (is (= -709792299180922954 (x/value (x/next x))))
;     (is (= -6877720052118061367 (x/value (x/next (x/next x))))))
;
;   ; References generated by https://ideone.com/PuauK5 using the C reference implementation.
;   (let [iterator (fn [a b] (map x/value (iterate x/next (x/xoroshiro128+ a b))))]
;     (is (=  '(5915700289933183508
;               -1558954363250675631
;               1539657768162236093
;               -8431081888899236472
;               4074320157442668224
;               -8533182883670957849
;               -1526802202569055637
;               4850584859890061851
;               8634885833871017437
;               951158310114151668
;               -4036337231569826939
;               8611270869943596899
;               7018510003645386554
;               -6795935637186553108
;               -4624131008753776202
;               372564000562090156
;               6859481897331970453
;               -538149764789634741
;               1466816894539304563
;               -3606614033023745357)
;             (take 20 (iterator -5272350857503343987 -7258692926273024121)))))
;
;   (let [iterator (fn [a b] (map x/value (iterate x/next (x/xoroshiro128+ a b))))]
;     (is (=  '(-8578920952240901094
;               -6487534394338226528
;               2764200532191932311
;               5335387613884335740
;               1839948030858925012
;               -7973224912611020956
;               2551562045061459880
;               -5525989048507934678
;               4229265504746057216
;               -4069894182678871317
;               -7553564479743607123
;               8111898360903549442
;               4725246142996591409
;               8782331531474316592
;               -295811702305402749
;               -2380515216488501046
;               4460300165800464164
;               7712752344217628412
;               456423108839055359
;               -5643491909635081635)
;             (take 20 (iterator -8225400499032730153 -353520453208170941)))))
;
;   (let [iterator (fn [a b] (map x/value (iterate x/next (x/xoroshiro128+ a b))))]
;     (is (=  '(-2714170201264899768
;               -1407769210302857770
;               -8870355780905176385
;               7651281371634664910
;               -1851793852725403807
;               5398593226664916035
;               -2499710751108373161
;               3790334130960207628
;               -4549407293332968031
;               -3494298676208843722
;               5073366846343845174
;               9164225786785933557
;               -6236557002069440799
;               1848516810561049622
;               -4937631416431947741
;               6539669931865202127
;               4408145272191338804
;               6921764645921579858
;               -8733157623936083508
;               -8100575772512211386)
;             (take 20 (iterator -4662309351488326550 1948139150223426782)))))
;
;   (let [iterator (fn [a b] (map x/value (iterate x/next (x/xoroshiro128+ a b))))]
;     (is (=  '(-4121496229006008560
;               -3383723555119512146
;               -1933504188657904426
;               -7466416979647767106
;               -5727051145790414991
;               1833256616643247313
;               -5201551263828128579
;               538678157558092550
;               -3342913672601878355
;               -1136443397401111913
;               -5730963972448837499
;               970469368782993999
;               3193470605279722807
;               -2044684518233872490
;               -4321572028526598124
;               -8503075182810095327
;               -506552873591169430
;               -6449026570454392506
;               -6847437900125755298
;               -760090062958374858)
;             (take 20 (iterator -5279509386902751759 1158013157896743199)))))
;
;   (let [iterator (fn [a b] (map x/value (iterate x/next (x/xoroshiro128+ a b))))]
;     (is (=  '(-3706720492587120323
;               5534242416345417728
;               -362310399193671027
;               450793391533003795
;               -7979320742418194277
;               7222408043579796109
;               -5412584949384491544
;               -8172053099165754120
;               -9017917230352423104
;               3172883245738333508
;               -1361123297417885575
;               1987544378930201407
;               -3543879845457455972
;               -7302607744029067661
;               -2159218809787252040
;               -193332270841612227
;               8441597738709619586
;               -4576302444254675749
;               -9152651193963047247
;               -76386203971839276)
;             (take 20 (iterator -3963057978039743073 256337485452622750))))))
