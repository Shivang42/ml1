import numpy as np
from nn1 import load
import tensorflow.compat.v1 as tf
tf.disable_v2_behavior()
import tensorflow.keras as keras


xtrain,ytrain = load('',kind='train')
xtest,ytest = load('',kind='test')
xtrain,xtest = xtrain.reshape(60000,784),xtest.reshape(10000,784)

means = np.mean(xtrain,axis=0)
stds = np.std(xtrain)
xtrainscaled = (xtrain-means)/stds
xtestscaled = (xtest-means)/stds

n_features = xtrainscaled.shape[1]
n_classes=10
random_seed = 123
np.random.seed(random_seed)

'''
g = tf.Graph()
with g.as_default():
    tf.set_random_seed(random_seed)
    tfx = tf.placeholder(dtype=tf.float32,shape=(None,n_features),name='tfx')
    tfy = tf.placeholder(dtype=tf.int32,shape=(None),name='tfy')
    yoh = tf.one_hot(indices=tfy,depth=n_classes)
    h1 = tf.layers.dense(inputs=tfx,units=50,activation=tf.tanh,name='layer1')
    h2 = tf.layers.dense(inputs=h1,units=50,activation=tf.tanh,name='layer2')
    logits = tf.layers.dense(inputs=h2,units=10,activation=None,name='layer3')
    predictions = {
        'classes':tf.argmax(logits,axis=1,name='predicted_classes'),
        'probabilities':tf.nn.softmax(logits,name='softmax_tensor')
        }
with g.as_default():
    cost = tf.losses.softmax_cross_entropy(onehot_labels=yoh,logits=logits)
    optimizer = tf.train.GradientDescentOptimizer(learning_rate=0.001)
    train = optimizer.minimize(loss=cost)
    init = tf.global_variables_initializer()
def create_batches(x,y,shuffle=False,bsize=75):
    xcopy,ycopy = np.array(x),np.array(y)
    if shuffle:
        data = np.column_stack((xcopy,ycopy))
        np.random.shuffle(data)
        xcopy = data[:,:-1]
        ycopy = data[:,-1]
    for i in range(0,x.shape[0],bsize):
        yield xcopy[i:i+bsize],ycopy[i:i+bsize]
sess = tf.Session(graph=g)
sess.run(init)
for epoch in range(50):
    training_costs = []
    generator = create_batches(xtrainscaled,ytrain,shuffle=True)
    for batchx,batchy in generator:
        feed = {tfx:batchx,tfy:batchy}
        _,bcost = sess.run([train,cost],feed_dict=feed)
        training_costs.append(bcost)
    print('epoch '+str(epoch)+' ; '+str(np.mean(training_costs)))
feed = {tfx:xtestscaled}
ypred = sess.run(predictions['classes'],feed_dict=feed)
print(100*(np.sum(ytest==ypred)/ytest.shape[0])) 
    '''
ytrainonehot = keras.utils.to_categorical(ytrain)
model = keras.models.Sequential()
model.add(
    keras.layers.Dense(
        units=50,
        input_dim=xtrainscaled.shape[1],
        kernel_initializer='glorot_uniform',
        bias_initializer='zeros',
        activation='tanh'
        ))
model.add(
    keras.layers.Dense(
        units=50,
        input_dim=50,
        kernel_initializer='glorot_uniform',
        bias_initializer='zeros',
        activation='tanh'
        ))
model.add(
    keras.layers.Dense(
        units=ytrainonehot.shape[1],
        input_dim=50,
        kernel_initializer='glorot_uniform',
        bias_initializer='zeros',
        activation='softmax'
        ))
sgdoptimizer = keras.optimizers.SGD(lr=0.001,decay=1e-7,momentum=0.9)
model.compile(optimizer=sgdoptimizer,loss='categorical_crossentropy')
history = model.fit(xtrainscaled,ytrainonehot,batch_size=64,epochs=50,verbose=1,validation_split=0.1)

